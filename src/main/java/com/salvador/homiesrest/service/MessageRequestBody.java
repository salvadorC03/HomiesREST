/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.salvador.homiesrest.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 *
 * @author salvador
 */
@Data
@RequiredArgsConstructor
public class MessageRequestBody {
    private final String author;
    private final String text;
}
