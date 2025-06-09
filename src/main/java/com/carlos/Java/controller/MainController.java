package com.carlos.Java.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.carlos.Java.model.Item;
import com.carlos.Java.model.ItemService;
import com.carlos.Java.model.Pessoa;
import com.carlos.Java.model.PessoaService;
import com.carlos.Java.model.Pessoa_Item;
import com.carlos.Java.model.Pessoa_ItemService;


@Controller
public class MainController {

    @Autowired
    private ApplicationContext context;

    @GetMapping("/")
    public String index(){
        return "index";
    }
    //--------- Cadastrar pessoa ----------------------------------------------------------------------
    @GetMapping("/cadastropessoa")
    public String cadastropessoa(Model model){
        model.addAttribute("pessoa", new Pessoa());
        model.addAttribute("nomePag", "CADASTRO DE PESSOAS");
        model.addAttribute("valorBtn", "Cadastrar");
        model.addAttribute("link","/cadastropessoa");
        return "cadastropessoa";
    }
    
    @PostMapping("/cadastropessoa")
    public String cadastropessoa(Model model, @ModelAttribute Pessoa pes){
        //PARA CADA TABELA, 1 SERVICE e 1 DAO, ALEM DE 1 POJO
        PessoaService ps = context.getBean(PessoaService.class);
        ps.inserirPessoa(pes);
        return "redirect:listarpessoa";
    }
    //--------- Editar pessoa ---------------------------------------------------------------------------
    @GetMapping("/editar/{id}")
    public String editarpessoa(Model model, @PathVariable int id){
        PessoaService ps = context.getBean(PessoaService.class);
        Map<String,Object> reg = ps.puxarPessoa(id);
        Pessoa pes = Pessoa.converterUmPessoa(reg);
        model.addAttribute("pessoa", pes);
        model.addAttribute("link", "/editar/" + id);
        model.addAttribute("nomePag", "EDITAR PESSOAS");
        model.addAttribute("valorBtn", "Atualizar");
        return "cadastropessoa";
    }

    @PostMapping("/editar/{id}")
    public String editarpessoa(@ModelAttribute Pessoa pes,
                         @PathVariable int id){
        PessoaService ps = context.getBean(PessoaService.class);
        ps.atualizarPessoa(pes,id);
        return "redirect:/listarpessoa";
    }

    //--------- deletar pessoa --------------------------------------------------------------------------
    @PostMapping("/deletar/{id}")
    public String deletar(@PathVariable int id){
        PessoaService ps = context.getBean(PessoaService.class);
        ps.deletar(id);
        return "redirect:/listarpessoa";
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    
    //--------- cadastrar item --------------------------------------------------------------------------
    @GetMapping("/cadastroitem")
    public String cadastroitem(Model model){
        model.addAttribute("item", new Item());
        model.addAttribute("nomePag", "CADASTRO DE ITENS");
        model.addAttribute("valorBtn", "Cadastrar");
        model.addAttribute("link","/cadastroitem");
        return "cadastroitem";
    }
    
    @PostMapping("/cadastroitem")
    public String cadastroitem(Model model, @ModelAttribute Item itm){
        //PARA CADA TABELA, 1 SERVICE e 1 DAO, ALEM DE 1 POJO
        ItemService is = context.getBean(ItemService.class);
        is.inserirItem(itm);
        return "redirect:listaritem";
    }
    //--------- Editar item ---------------------------------------------------------------------------
    @GetMapping("/editar2/{id}")
    public String editaritem(Model model, @PathVariable int id){
        ItemService is = context.getBean(ItemService.class);
        Map<String,Object> reg = is.puxaritem(id);
        Item itm = Item.converterUmItem(reg);
        model.addAttribute("item", itm);
        model.addAttribute("link", "/editar2/" + id);
        model.addAttribute("nomePag", "EDITAR ITEM");
        model.addAttribute("valorBtn", "Atualizar");
        return "cadastroitem";
    }
    

    @PostMapping("/editar2/{id}")
    public String editaritem(@ModelAttribute Item itm,
                             @PathVariable int id){
        ItemService is = context.getBean(ItemService.class);
        is.atualizarItem(itm, id);
        return "redirect:/listaritem";
    }
    //--------- deletar item --------------------------------------------------------------------------
    @PostMapping("/deletar2/{id}")
    public String deletaritem(@PathVariable int id){
            ItemService is = context.getBean(ItemService.class);
            is.deletar(id);
            return "redirect:/listaritem";
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    //--------- cadastrar pessoa_item --------------------------------------------------------------------------
    @GetMapping("/cadastropessoa_item")
    public String cadastropessoa_item(Model model){
        model.addAttribute("pessoa_itens", new Pessoa_Item());
        model.addAttribute("nomePag", "CADASTRO DE PESSOA_ITEM");
        model.addAttribute("valorBtn", "Cadastrar");
        model.addAttribute("link","/cadastropessoa_item");
        return "cadastropessoa_item";
    }

    @PostMapping("/cadastropessoa_item")
    public String cadastropessoa_item(Model model, @ModelAttribute Pessoa_Item psi){
        //PARA CADA TABELA, 1 SERVICE e 1 DAO, ALEM DE 1 POJO
        Pessoa_ItemService pis = context.getBean(Pessoa_ItemService.class);
        pis.inserirPessoa_item(psi);
        return "redirect:/listarpessoa_item";
    }

    //--------- Editar item ---------------------------------------------------------------------------
    @GetMapping("/editar3/{id}")
    public String editarppessoa_item(Model model, @PathVariable int id){
        Pessoa_ItemService pis = context.getBean(Pessoa_ItemService.class);
        Map<String,Object> reg = pis.puxarPessoa_Item(id);
        System.out.println(reg);
        Pessoa_Item psi = Pessoa_Item.converterUmLigacao2(reg);
        System.out.println(psi);
        System.out.println(model.addAttribute("pessoa_itens", psi));
        System.out.println(model.addAttribute("link", "/editar3/" + id));
        System.out.println(model.addAttribute("nomePag", "EDITAR ITEM"));
        System.out.println(model.addAttribute("valorBtn", "Atualizar"));
        model.addAttribute("Pessoa_itens", psi);
        model.addAttribute("link", "/editar3/" + id);
        model.addAttribute("nomePag", "EDITAR ITEM");
        model.addAttribute("valorBtn", "Atualizar");

        return "cadastropessoa_item";
    }
    
    @PostMapping("/editar3/{id}")
    public String editarpessoa_item(@ModelAttribute Pessoa_Item psi,
                                    @PathVariable int id){
        Pessoa_ItemService pis = context.getBean(Pessoa_ItemService.class);
        pis.atualizarPessoa_Item(psi, id);
        return "redirect:/listarpessoa_item";
    }
    //--------- deletar item --------------------------------------------------------------------------
    @PostMapping("/deletar3/{id}")
    public String deletarppessoa_item(@PathVariable int id){
            Pessoa_ItemService pis = context.getBean(Pessoa_ItemService.class);
            pis.deletar(id);
            return "redirect:/listarpessoa_item";
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    @GetMapping("/listarpessoa_item")
    public String listarpessoa_item(Model model){
        Pessoa_ItemService pis = context.getBean(Pessoa_ItemService.class);
        List<Map<String,Object>> lr = pis.puxarTodosPessoa_Item();
        List<Pessoa_Item> lp = Pessoa_Item.converterNLigacao(lr);
        model.addAttribute("pessoa_item",lp);
        return "lista3";
    }

    @GetMapping("/listaritem")
    public String listaritem(Model model){
        ItemService is = context.getBean(ItemService.class);
        List<Map<String,Object>> lr = is.puxarTodosItens();
        List<Item> lp = Item.converterNItens(lr);
        model.addAttribute("itens",lp);
        return "lista2";
    }

    @GetMapping("/listarpessoa")
    public String listarpessoa(Model model){
        PessoaService ps = context.getBean(PessoaService.class);
        List<Map<String,Object>> lr = ps.puxarTodosPessoas();
        List<Pessoa> lp = Pessoa.converterNPessoas(lr);
        model.addAttribute("pessoas",lp);
        return "lista";
    }
}
