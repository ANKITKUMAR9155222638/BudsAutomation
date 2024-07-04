package com.mobilefirstapplication.buds;

import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;

public class HelloWorld {

	@Test
    public void testGetHelloWorldMessage() {
        HelloWorld helloWorld = new HelloWorld();
        String expectedOutput = "hwlloworld ";
        Assert.assertEquals(helloWorld.testGetHelloWorldMessage(), expectedOutput, "The output is incorrect.");
    }
}