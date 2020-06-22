package com.fuimonosapp.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(schema = "public", name = "restaurante")
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurante_id")
    private Integer restaurante_id;

    @Column(name = "username")
    private String username;

    @Column(name = "pass")
    private String pass;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "restaurante")
    private List<Menu> menus;

    @Column(name = "horario_de_apertura")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date horario_de_apertura;

    @Column(name = "horario_de_cierre")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date horario_de_cierre;

    @Column(name = "imagen_de_portada")
    private String imagen_de_portada;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departamento_id")
    private Departamento departamento_id;

    @Column(name = "tiempo_estimado_de_entrega")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date tiempo_estimado_de_entrega;

    @Column(name = "descuento")
    private Integer descuento;
    
    @Column (name = "imagen")
    private String imagen;
    
    @Column(name="representante")
    private String representante;
    
    @Column(name="numero_de_contacto")
    private String numeroDeContacto;
    
    @Column(name="comision")
    private Double comision;
    
    @Column(name="cargos_extras")
    private Double cargosExtras;

    @Transient
    @OneToOne(mappedBy = "restaurante_id", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private Pedido pedido;

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Date getHorario_de_apertura() {
        return horario_de_apertura;
    }

    public void setHorario_de_apertura(Date horario_de_apertura) {
        this.horario_de_apertura = horario_de_apertura;
    }

    public Date getHorario_de_cierre() {
        return horario_de_cierre;
    }

    public void setHorario_de_cierre(Date horario_de_cierre) {
        this.horario_de_cierre = horario_de_cierre;
    }

    public String getImagen_de_portada() {
        return imagen_de_portada;
    }

    public void setImagen_de_portada(String imagen_de_portada) {
        this.imagen_de_portada = imagen_de_portada;
    }

    public Departamento getDepartamento_id() {
        return departamento_id;
    }

    public void setDepartamento_id(Departamento departamento_id) {
        this.departamento_id = departamento_id;
    }

    public Date getTiempo_estimado_de_entrega() {
        return tiempo_estimado_de_entrega;
    }

    public void setTiempo_estimado_de_entrega(Date tiempo_estimado_de_entrega) {
        this.tiempo_estimado_de_entrega = tiempo_estimado_de_entrega;
    }

    public Integer getDescuento() {
        return descuento;
    }

    public void setDescuento(Integer descuento) {
        this.descuento = descuento;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public Integer getRestaurante_id() {
        return restaurante_id;
    }

    public void setRestaurante_id(Integer restaurante_id) {
        this.restaurante_id = restaurante_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String password) {
        this.pass = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public String getNumeroDeContacto() {
        return numeroDeContacto;
    }

    public void setNumeroDeContacto(String numeroDeContacto) {
        this.numeroDeContacto = numeroDeContacto;
    }

    public Double getComision() {
        return comision;
    }

    public void setComision(Double comision) {
        this.comision = comision;
    }

    public Double getCargosExtras() {
        return cargosExtras;
    }

    public void setCargosExtras(Double cargosExtras) {
        this.cargosExtras = cargosExtras;
    }
    
    

    public Restaurante() {

    }

}
