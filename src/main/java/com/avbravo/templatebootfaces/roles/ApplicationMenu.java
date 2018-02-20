/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/
package com.avbravo.templatebootfaces.roles;

import com.avbravo.avbravoutils.menu.MenuElement;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @authoravbravo
 */
@Named
@SessionScoped
public class ApplicationMenu implements Serializable {

    private static final long serialVersionUID = 1L;
    public ApplicationMenu() {
    }
    /*
     barra de menu
     */
    private Boolean menuBarHorarios = false;
    private Boolean menuBarRegistros = false;
    private Boolean menuBarReportes = false;
    private Boolean menuBarAdministracion = false;
        
    /*
     elementos
     */
   MenuElement agente = new MenuElement();
   MenuElement diasfestivo = new MenuElement();
   MenuElement marcacion = new MenuElement();
   MenuElement permiso = new MenuElement();
   MenuElement reservado = new MenuElement();
   MenuElement reservadoagente = new MenuElement();
   MenuElement rol = new MenuElement();
   MenuElement usuario = new MenuElement();
   MenuElement vacacion = new MenuElement();
        
    public void enabledAll(Boolean activo) {
        menuBarHorarios = activo;
        menuBarRegistros = activo;
        menuBarReportes = activo;
        menuBarAdministracion = activo;
       agente.initialize(activo);
       diasfestivo.initialize(activo);
       marcacion.initialize(activo);
       permiso.initialize(activo);
       reservado.initialize(activo);
       reservadoagente.initialize(activo);
       rol.initialize(activo);
       usuario.initialize(activo);
       vacacion.initialize(activo);
        
    }
    public Boolean getMenuBarHorarios(){
        return menuBarHorarios;
    }
    public void setMenuBarHorarios(Boolean menuBarHorarios){
        this.menuBarHorarios= menuBarHorarios;
    }
    public Boolean getMenuBarRegistros(){
        return menuBarRegistros;
    }
    public void setMenuBarRegistros(Boolean menuBarRegistros){
        this.menuBarRegistros= menuBarRegistros;
    }
    public Boolean getMenuBarReportes(){
        return menuBarReportes;
    }
    public void setMenuBarReportes(Boolean menuBarReportes){
        this.menuBarReportes= menuBarReportes;
    }
    public Boolean getMenuBarAdministracion(){
        return menuBarAdministracion;
    }
    public void setMenuBarAdministracion(Boolean menuBarAdministracion){
        this.menuBarAdministracion= menuBarAdministracion;
    }
   public MenuElement getAgente(){
       return agente;
   }
   public void setAgente(MenuElement agente){
       this.agente= agente;
   }
   public MenuElement getDiasfestivo(){
       return diasfestivo;
   }
   public void setDiasfestivo(MenuElement diasfestivo){
       this.diasfestivo= diasfestivo;
   }
   public MenuElement getMarcacion(){
       return marcacion;
   }
   public void setMarcacion(MenuElement marcacion){
       this.marcacion= marcacion;
   }
   public MenuElement getPermiso(){
       return permiso;
   }
   public void setPermiso(MenuElement permiso){
       this.permiso= permiso;
   }
   public MenuElement getReservado(){
       return reservado;
   }
   public void setReservado(MenuElement reservado){
       this.reservado= reservado;
   }
   public MenuElement getReservadoagente(){
       return reservadoagente;
   }
   public void setReservadoagente(MenuElement reservadoagente){
       this.reservadoagente= reservadoagente;
   }
   public MenuElement getRol(){
       return rol;
   }
   public void setRol(MenuElement rol){
       this.rol= rol;
   }
   public MenuElement getUsuario(){
       return usuario;
   }
   public void setUsuario(MenuElement usuario){
       this.usuario= usuario;
   }
   public MenuElement getVacacion(){
       return vacacion;
   }
   public void setVacacion(MenuElement vacacion){
       this.vacacion= vacacion;
   }




}
