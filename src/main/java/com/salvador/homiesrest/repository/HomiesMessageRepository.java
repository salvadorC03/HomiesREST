/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.salvador.homiesrest.repository;

import com.salvador.homiesrest.model.HomiesMessage;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author salvador
 */
public interface HomiesMessageRepository extends JpaRepository<HomiesMessage, Long> {
}
