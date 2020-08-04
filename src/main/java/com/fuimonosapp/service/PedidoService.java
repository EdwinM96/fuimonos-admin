/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.service;

import com.fuimonosapp.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fuimonosapp.domain.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 *
 * @author HP PC
 */

@Service
public class PedidoService {
    
    @Autowired
    PedidoRepository pRepo;
    
    int PAGESIZE = 10;
    
    public Page<Pedido> findAll(Integer page){
        return pRepo.findAll(PageRequest.of(page, PAGESIZE));
    }
    
    public Pedido updatePedido(Pedido pedido){
        return pRepo.save(pedido);
    }

    public Pedido findOne(Integer pedidoId) {
        return pRepo.findById(pedidoId).get();
    }

    public Pedido update(Pedido pedido) {
       return pRepo.saveAndFlush(pedido);
    }
    
}
