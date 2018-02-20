/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/
package com.avbravo.templatebootfaces.roles;

import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import java.io.Serializable;

/**
 *
 * @authoravbravo
 */
@Named
@RequestScoped
public class RolPrueba implements Serializable{
private static final long serialVersionUID = 1L;

 @Inject
 ApplicationMenu applicationMenu;
    /**
     * Creates a new instance of RolAdministrador
     */
    public RolPrueba() {
    }
 public void enabled() {
        /*
         *barra
         */
        
      applicationMenu.setMenuBarHorarios(Boolean.TRUE);
      applicationMenu.setMenuBarRegistros(Boolean.TRUE);
      applicationMenu.setMenuBarReportes(Boolean.TRUE);
      applicationMenu.setMenuBarAdministracion(Boolean.TRUE);
        /*
         *menu
         */
        
      applicationMenu.getAgente().initialize(Boolean.TRUE);
      applicationMenu.getDiasfestivo().initialize(Boolean.TRUE);
      applicationMenu.getMarcacion().initialize(Boolean.TRUE);
      applicationMenu.getPermiso().initialize(Boolean.TRUE);
      applicationMenu.getReservado().initialize(Boolean.TRUE);
      applicationMenu.getReservadoagente().initialize(Boolean.TRUE);
      applicationMenu.getRol().initialize(Boolean.TRUE);
      applicationMenu.getUsuario().initialize(Boolean.TRUE);
      applicationMenu.getVacacion().initialize(Boolean.TRUE);
     
    }




}
