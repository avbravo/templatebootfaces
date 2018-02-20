/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.templatebootfaces.controller;

// <editor-fold defaultstate="collapsed" desc="imports">
import com.avbravo.avbravoutils.JsfUtil;
import com.avbravo.templatebootfaces.entity.Usuario;
import com.avbravo.templatebootfaces.roles.ValidadorRoles;
import com.avbravo.templatebootfaces.util.ResourcesFiles;
import javax.inject.Inject;

import java.util.logging.Logger;
import javax.inject.Named;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
// </editor-fold>

/**
 *
 * @authoravbravo
 */
@Named
@SessionScoped
public class LoginController implements Serializable {
// <editor-fold defaultstate="collapsed" desc="fields">

    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(LoginController.class.getName());

 
   
    //Acceso
  
    @Inject
    ResourcesFiles rf;
    @Inject
    ValidadorRoles validadorRoles;
    Boolean loggedIn = false;
    private String username;
    private String password;
    private String foto;
    private String id;
    private String key;
    String usernameSelected;
    Boolean recoverSession = false;
    Boolean userwasLoged = false;
    Boolean tokenwassend = false;
    String usernameRecover = "";
    String myemail = "@gmail.com";
    String mytoken = "";
   
    Usuario usuario = new Usuario();
   
    // </editor-fold>
// <editor-fold defaultstate="collapsed" desc="getter/setter">

  
    public String getMyemail() {
        return myemail;
    }

    public void setMyemail(String myemail) {
        this.myemail = myemail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(Boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public Boolean getTokenwassend() {
        return tokenwassend;
    }

    public void setTokenwassend(Boolean tokenwassend) {
        this.tokenwassend = tokenwassend;
    }

    public String getMytoken() {
        return mytoken;
    }

    public void setMytoken(String mytoken) {
        this.mytoken = mytoken;
    }

    public String getUsernameSelected() {
        return usernameSelected;
    }

    public void setUsernameSelected(String usernameSelected) {
        this.usernameSelected = usernameSelected;
    }

    public Boolean getUserwasLoged() {
        return userwasLoged;
    }

    public void setUserwasLoged(Boolean userwasLoged) {
        this.userwasLoged = userwasLoged;
    }
    // </editor-fold>

// <editor-fold defaultstate="collapsed" desc="init">
    @PostConstruct
    public void init() {
        loggedIn = false;
        recoverSession = false;
        userwasLoged = false;
        tokenwassend = false;
    }

    // </editor-fold>
// <editor-fold defaultstate="collapsed" desc="destroy">
    @PreDestroy
    public void destroy() {
    }

    // </editor-fold>
// <editor-fold defaultstate="collapsed" desc="constructor">
    public LoginController() {
    }

    // </editor-fold>
// <editor-fold defaultstate="collapsed" desc="irLogin">
    public String irLogin() {
//        return "/faces/login";
        return "/login";
    }

    // </editor-fold>
// <editor-fold defaultstate="collapsed" desc="doLogin">
    public String doLogin() {
        try {

            tokenwassend = false;
            userwasLoged = false;
            loggedIn = true;
            usuario = new Usuario();
            if (username == null || password == null) {
                JsfUtil.warningMessage(rf.getAppMessage("login.usernamenotvalid"));
                return null;
            }
           
            if (!isUserValid()) {
             
                JsfUtil.warningMessage(rf.getAppMessage("login.usernameorpasswordnotvalid"));
                return "";

            }
          
            
            loggedIn = true;
            foto = "img/me.jpg";
            JsfUtil.successMessage(rf.getAppMessage("login.welcome") + " " + usuario.getNombre());
          return "/faces/index.xhtml?faces-redirect=true";
          
  //              return "/dashboard.xhtml?faces-redirect=true";


        } catch (Exception e) {
            JsfUtil.errorMessage(e, "doLogin()");
        }
        return "";
    }

    // </editor-fold>
// <editor-fold defaultstate="collapsed" desc="isValid">
    /**
     * verifica si es valido el usuario
     *
     * @return
     */
    private Boolean isUserValid() {
        Boolean isvalid = false;
        try {
            if (username.isEmpty() || username.equals("") || username == null) {
                JsfUtil.successMessage(rf.getAppMessage("warning.usernameisempty"));
                return false;
            }
            if (password.isEmpty() || password.equals("") || password == null) {
                JsfUtil.successMessage(rf.getAppMessage("warning.passwordisempty"));
                return false;
            }
            
            usuario.setUsername("demo");
            usuario.setPassword("demo");
            usuario.setNombre("Usuario demo");
            usuario.setRol("Administrador");
            
                    
            if (!username.equals(usuario.getUsername())) {
                JsfUtil.warningMessage(rf.getAppMessage("login.usernamenotvalid"));
                return false;
            } else {
               
                if (!usuario.getPassword().equals(password)) {
                    JsfUtil.successMessage(rf.getAppMessage("login.passwordnotvalid"));
                    return false;
                }
                if (!validadorRoles.validarRoles(usuario.getRol())) {
                    JsfUtil.successMessage(rf.getAppMessage("login.notienerolenelsistema") + " " + usuario.getRol());
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            JsfUtil.errorMessage("userValid() " + e.getLocalizedMessage());
        }
        return isvalid;
    }// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="sendToken()"> 

   
// <editor-fold defaultstate="collapsed" desc="doLogout">

    public String doLogout() {
         try {
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            if (session != null) {
                session.invalidate();
            }
           // String url = (path);
            FacesContext fc = FacesContext.getCurrentInstance();
            ExternalContext ec = fc.getExternalContext();
            ec.redirect("/templatebootfaces/faces/login.xhtml?faces-redirect=true");
       // return "/templatebootfaces/faces/login.xhtml?faces-redirect=true";
    }catch(Exception ex){
             System.out.println("doLogout() "+ex.getLocalizedMessage());
    }
         return "";
    }
         

    // </editor-fold>


}
