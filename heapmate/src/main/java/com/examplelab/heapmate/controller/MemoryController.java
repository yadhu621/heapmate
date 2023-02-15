package com.examplelab.heapmate.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemoryController {
  
  private static final Logger LOGGER = LoggerFactory.getLogger(MemoryController.class);

  @GetMapping("/memory")
  public long getMemoryUsage() {
    Runtime runtime = Runtime.getRuntime();
    long currentMemoryUsage = (runtime.totalMemory() - runtime.freeMemory()) / 1024 / 1024;
  
    LOGGER.info("Current memory usage: {} MB", currentMemoryUsage);
    return currentMemoryUsage;
  }

  @PostMapping("/memory/allocate")
  public void allocateMemory(@RequestParam("value") long value) {
    byte[] bytes = new byte[(int) value * 1024 * 1024];

    Runtime runtime = Runtime.getRuntime();
    long currentMemoryUsage = (runtime.totalMemory() - runtime.freeMemory()) / 1024 / 1024;
    LOGGER.info("Current memory usage: {} MB", currentMemoryUsage);
  }

  @PostMapping("/memory/dialup")
  public void dialUp(@RequestParam("value") long value) {
    LOGGER.info("Dialling UP by approx. {} MB", value);
    Runtime runtime = Runtime.getRuntime();
    long currentMemoryUsage = (runtime.totalMemory() - runtime.freeMemory()) / 1024 / 1024;
    byte[] bytes = new byte[(int) (currentMemoryUsage + value) * 1024 * 1024];
    
    long redialedMemoryUsage = (runtime.totalMemory() - runtime.freeMemory()) / 1024 / 1024;
    LOGGER.info("Current memory usage: {} MB", redialedMemoryUsage);
  }

  @PostMapping("/memory/dialdown")
  public void dialDown(@RequestParam("value") long value) {
    LOGGER.info("Dialling DOWN by approx. {} MB", value);
    Runtime runtime = Runtime.getRuntime();
    long currentMemoryUsage = (runtime.totalMemory() - runtime.freeMemory()) / 1024 / 1024;
    byte[] bytes = new byte[(int) (currentMemoryUsage - value) * 1024 * 1024];

    long redialedMemoryUsage = (runtime.totalMemory() - runtime.freeMemory()) / 1024 / 1024;
    LOGGER.info("Current memory usage: {} MB", redialedMemoryUsage);
    }
  
}