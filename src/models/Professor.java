/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.time.LocalDate;

/**
 *
 * @author willi
 */
public class Professor {
    private int id_professor;
    private String nome;
    private String email;
    private String especialidade;
    private String endereco;
    private String TelefoneCelular;
    private String WhatsApp;

    public int getId_professor() {
        return id_professor;
    }

    public void setId_professor(int id_professor) {
        this.id_professor = id_professor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefoneCelular() {
        return TelefoneCelular;
    }

    public void setTelefoneCelular(String TelefoneCelular) {
        this.TelefoneCelular = TelefoneCelular;
    }

    public String getWhatsApp() {
        return WhatsApp;
    }

    public void setWhatsApp(String WhatsApp) {
        this.WhatsApp = WhatsApp;
    }
    
    @Override
    public String toString() {
        return "ID: " + this.getId_professor() + " - " + this.getNome(); // Retorna só o nome para aparecer na lista Combo Box mantendo todo o objeto
    }
}
