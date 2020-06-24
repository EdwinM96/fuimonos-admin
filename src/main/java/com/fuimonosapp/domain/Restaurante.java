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
import javax.persistence.Lob;
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
    private Integer restauranteId;

    @Column(name = "username")
    private String username;

    @Column(name = "pass")
    private String pass;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "restaurante")
    private List<Menu> menus;

    @Column(name = "horario_de_apertura")
    @Temporal(TemporalType.TIMESTAMP)
     @DateTimeFormat(pattern="hh:mm")
    private Date horarioDeApertura;

    @Column(name = "horario_de_cierre")
    @Temporal(TemporalType.TIMESTAMP)
     @DateTimeFormat(pattern="hh:mm")
    private Date horarioDeCierre;

    @Column(name = "imagen_de_portada")
    private Byte[] imagenDePortada;

    @Column(name = "tiempo_estimado_de_entrega")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern="hh:mm")
    private Date tiempoEstimadoDeEntrega;

    @Column(name = "descuento")
    private Integer descuento;
    
    
    @Column(name="representante")
    private String representante;
    
    @Column(name="numero_de_contacto")
    private String numeroDeContacto;
    
    @Column(name="comision")
    private Double comision;
    
    @Column(name="cargos_extras")
    private Double cargosExtras;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departamento_id")
    private Departamento departamento_id;

    @Transient
    @OneToOne(mappedBy = "restaurante_id", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private Pedido pedido;

    public Integer getRestauranteId() {
        return restauranteId;
    }

    public void setRestauranteId(Integer restauranteId) {
        this.restauranteId = restauranteId;
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

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public Date getHorarioDeApertura() {
        return horarioDeApertura;
    }

    public void setHorarioDeApertura(Date horarioDeApertura) {
        this.horarioDeApertura = horarioDeApertura;
    }

    public Date getHorarioDeCierre() {
        return horarioDeCierre;
    }

    public void setHorarioDeCierre(Date horarioDeCierre) {
        this.horarioDeCierre = horarioDeCierre;
    }

    public Byte[] getImagenDePortada() {
        return imagenDePortada;
    }

    public void setImagenDePortada(Byte[] imagenDePortada) {
        this.imagenDePortada = imagenDePortada;
    }

    public Date getTiempoEstimadoDeEntrega() {
        return tiempoEstimadoDeEntrega;
    }

    public void setTiempoEstimadoDeEntrega(Date tiempoEstimadoDeEntrega) {
        this.tiempoEstimadoDeEntrega = tiempoEstimadoDeEntrega;
    }

    public Integer getDescuento() {
        return descuento;
    }

    public void setDescuento(Integer descuento) {
        this.descuento = descuento;
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

    public Departamento getDepartamento_id() {
        return departamento_id;
    }

    public void setDepartamento_id(Departamento departamento) {
        this.departamento_id = departamento;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    

    public Restaurante() {

    }

}
