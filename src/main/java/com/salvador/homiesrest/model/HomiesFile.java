/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.salvador.homiesrest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 *
 * @author salvador
 */
@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class HomiesFile {
    private String name;
    private String contentType;
    private String downloadURL;
}
