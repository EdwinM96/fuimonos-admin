/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Page;

/**
 *
 * @author HP PC
 */
public class PagingAndSorting {
    /* The urlKeyword is the target path you want the final URL to have for ex. localhost/restaurante?page=2 would translate into a urlKeyword of "restaurante"*/
    public static Map<String,Object> generalPagingAndSorting(Page objectPage, HttpServletRequest request, String searchWord, String sorting, String urlKeyword) throws UnsupportedEncodingException{
        Map<String,Object> valuesMap = new HashMap();
        Integer resultsPage = objectPage.getNumber();
        Integer totalPageCount = objectPage.getTotalPages();
        if(searchWord!=null){
            searchWord = URLEncoder.encode(searchWord, StandardCharsets.UTF_8.toString());
        }
        /*Este es if es en el caso que la página sea la primera, revisamos si hay más páginas y si es así agregamos los resultados al mapa*/
        if(resultsPage==0){
            valuesMap.put("firstPage", true);
            valuesMap.put("firstPageNumber",1);
            if(totalPageCount.equals(2)){
                valuesMap.put("secondPageExist", true);
                valuesMap.put("secondPageNumber", 2);
                valuesMap.put("nextPageExist",true);
                valuesMap.put("secondPageUrl",request.getContextPath()+"/"+urlKeyword+"?page=1"+(searchWord!=null?"&searchWord="+searchWord:"")+(sorting!=null?"&sorting="+sorting:""));
                valuesMap.put("nextPageUrl",request.getContextPath()+"/"+urlKeyword+"?page=1"+(searchWord!=null?"&searchWord="+searchWord:"")+(sorting!=null?"&sorting="+sorting:""));
            }
            else if(totalPageCount>2){
                valuesMap.put("thirdPageExist", true);
                valuesMap.put("nextPageExist",true);
                valuesMap.put("secondPageExist", true);
                valuesMap.put("secondPageNumber", 2);
                valuesMap.put("thirdPageNumber",3);
                valuesMap.put("secondPageUrl",request.getContextPath()+"/"+urlKeyword+"?page=1"+(searchWord!=null?"&searchWord="+searchWord:"")+(sorting!=null?"&sorting="+sorting:""));
                valuesMap.put("thirdPageUrl",request.getContextPath()+"/"+urlKeyword+"?page=2"+(searchWord!=null?"&searchWord="+searchWord:"")+(sorting!=null?"&sorting="+sorting:""));
                valuesMap.put("nextPageUrl",request.getContextPath()+"/"+urlKeyword+"?page=1"+(searchWord!=null?"&searchWord="+searchWord:"")+(sorting!=null?"&sorting="+sorting:""));
            }
        }
        /*Else para indicar que estamos hablando de una entrada posterior a la primera página*/
        else{
            valuesMap.put("firstPage", false);
            //Estamos al final de las páginas, en la posición de las páginas 3
            if(totalPageCount.equals(resultsPage+1) && totalPageCount>2){
                valuesMap.put("secondPageExist",true);
                valuesMap.put("thirdPage",true);
                valuesMap.put("thirdPageExist",true);
                valuesMap.put("lastPageUrl",request.getContextPath()+"/"+urlKeyword+"?page="+(resultsPage-1)+(searchWord!=null?"&searchWord="+searchWord:"")+(sorting!=null?"&sorting="+sorting:""));
                valuesMap.put("secondPageUrl",request.getContextPath()+"/"+urlKeyword+"?page="+(resultsPage-1)+(searchWord!=null?"&searchWord="+searchWord:"")+(sorting!=null?"&sorting="+sorting:""));
                valuesMap.put("firstPageUrl",request.getContextPath()+"/"+urlKeyword+"?page="+(resultsPage-2)+(searchWord!=null?"&searchWord="+searchWord:"")+(sorting!=null?"&sorting="+sorting:""));
                valuesMap.put("thirdPageNumber",resultsPage+1);
                valuesMap.put("secondPageNumber",resultsPage);
                valuesMap.put("firstPageNumber",resultsPage-1);
            }
            //Estamos al final de las páginas, en la posición de las páginas 2
            else if(totalPageCount.equals(resultsPage+1) && totalPageCount.equals(2)){
                valuesMap.put("secondPage",true);
                valuesMap.put("secondPageExist",true);
                valuesMap.put("lastPageUrl",request.getContextPath()+"/"+urlKeyword+"?page="+(resultsPage-1)+(searchWord!=null?"&searchWord="+searchWord:"")+(sorting!=null?"&sorting="+sorting:""));
                valuesMap.put("firstPageUrl",request.getContextPath()+"/"+urlKeyword+"?page="+(resultsPage-1)+(searchWord!=null?"&searchWord="+searchWord:"")+(sorting!=null?"&sorting="+sorting:""));
                valuesMap.put("secondPageNumber",resultsPage+1);
                valuesMap.put("firstPageNumber",resultsPage);
            }
            //Estamos a la mitad de las páginas, en la posición de las páginas 2
            else if(resultsPage+1 < totalPageCount && resultsPage!=0){
                valuesMap.put("secondPageExist",true);
                valuesMap.put("thirdPageExist",true);
                valuesMap.put("secondPage",true);
                valuesMap.put("lastPage",true);
                valuesMap.put("nextPageExist",true);
                valuesMap.put("lastPageUrl",request.getContextPath()+"/"+urlKeyword+"?page="+(resultsPage-1)+(searchWord!=null?"&searchWord="+searchWord:"")+(sorting!=null?"&sorting="+sorting:""));
                valuesMap.put("firstPageUrl",request.getContextPath()+"/"+urlKeyword+"?page="+(resultsPage-1)+(searchWord!=null?"&searchWord="+searchWord:"")+(sorting!=null?"&sorting="+sorting:""));
                valuesMap.put("nextPageUrl",request.getContextPath()+"/"+urlKeyword+"?page="+(resultsPage+1)+(searchWord!=null?"&searchWord="+searchWord:"")+(sorting!=null?"&sorting="+sorting:""));
                valuesMap.put("thirdPageUrl",request.getContextPath()+"/"+urlKeyword+"?page="+(resultsPage+1)+(searchWord!=null?"&searchWord="+searchWord:"")+(sorting!=null?"&sorting="+sorting:""));
                valuesMap.put("thirdPageNumber",resultsPage+2);
                valuesMap.put("secondPageNumber",resultsPage+1);    
                valuesMap.put("firstPageNumber",resultsPage);
            }
        }
        
        return valuesMap;
    }
    
}
