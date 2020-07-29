package com.fuimonosapp.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema = "public", name = "submenu")
public class Submenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "submenu_id")
    private Integer submenuId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "platillo_id")
    private Platillo platillo;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "menu_cobrado")
    private Boolean menucobrado;

    @Column(name = "cobrar_apartir_de")
    private Integer cobrarapartirde;

    @Column(name = "maximo_opciones_a_escoger")
    private Integer maximoopcionesaescoger;

    @Column(name = "minimo_opciones_a_escoger")
    private Integer minimoopcionesaescoger;

    @OneToMany(mappedBy = "opcionsubmenuId", fetch = FetchType.LAZY)
    private List<OpcionSubMenu> opcionesSubMenus;
    
    @Column(name = "orden")
    private Integer orden;

    public Integer getMinimoopcionesaescoger() {
        return minimoopcionesaescoger;
    }

    public void setMinimoopcionesaescoger(Integer minimoopcionesaescoger) {
        this.minimoopcionesaescoger = minimoopcionesaescoger;
    }

    public List<OpcionSubMenu> getOpcionesSubMenus() {
        return opcionesSubMenus;
    }

    public void setOpcionesSubMenus(List<OpcionSubMenu> opcionesSubMenus) {
        this.opcionesSubMenus = opcionesSubMenus;
    }

    public Integer getSubmenuId() {
        return submenuId;
    }

    public void setSubmenuId(Integer submenuId) {
        this.submenuId = submenuId;
    }

    public Platillo getPlatillo() {
        return platillo;
    }

    public void setPlatillo(Platillo platillo) {
        this.platillo = platillo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Boolean getMenucobrado() {
        return menucobrado;
    }

    public void setMenucobrado(Boolean menucobrado) {
        this.menucobrado = menucobrado;
    }

    public Integer getCobrarapartirde() {
        return cobrarapartirde;
    }

    public void setCobrarapartirde(Integer cobrarapartirde) {
        this.cobrarapartirde = cobrarapartirde;
    }

    public Integer getMaximoopcionesaescoger() {
        return maximoopcionesaescoger;
    }

    public void setMaximoopcionesaescoger(Integer maximoopcionesaescoger) {
        this.maximoopcionesaescoger = maximoopcionesaescoger;
    }

    public String getMenuCobradoDelegate() {
        if (this.menucobrado == null) {
            return "";
        } else {
            return menucobrado == true ? "Ativo" : "Inactivo";
        }
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }
    

    public Submenu() {

    }

}
