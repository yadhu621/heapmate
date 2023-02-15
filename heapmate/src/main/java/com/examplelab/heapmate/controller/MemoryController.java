package com.examplelab.heapmate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemoryController {
  @GetMapping("/memory")
  public long getMemoryUsage() {
    Runtime runtime = Runtime.getRuntime();
    long currentMemoryUsage = (runtime.totalMemory() - runtime.freeMemory()) / 1024 / 1024;
    return currentMemoryUsage;
  }
}