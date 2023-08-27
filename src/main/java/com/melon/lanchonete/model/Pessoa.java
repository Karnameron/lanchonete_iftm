package com.melon.lanchonete.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jdk.jfr.DataAmount;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.print.DocFlavor;
import java.time.LocalDate;
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@MappedSuperclass
public abstract class Pessoa {
    @Column(length = 50, nullable = false)
    @EqualsAndHashCode.Include
    protected String cpf;
    @Column(length = 11)
    protected String nome;
    @Column(length = 13)
    protected String telefone;
    @Column(length = 40)
    protected String email;
    protected LocalDate dataNascimento;
}
