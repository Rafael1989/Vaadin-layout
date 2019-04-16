package com.vaadin.training.layout.testbench;

import com.vaadin.flow.component.board.testbench.BoardElement;
import com.vaadin.flow.component.formlayout.testbench.FormLayoutElement;
import com.vaadin.flow.component.html.testbench.AnchorElement;
import com.vaadin.flow.component.html.testbench.DivElement;
import com.vaadin.flow.component.html.testbench.H1Element;
import com.vaadin.flow.component.orderedlayout.testbench.VerticalLayoutElement;
import com.vaadin.testbench.ElementQuery;
import com.vaadin.testbench.TestBenchTestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class SmokeTestIT extends TestBenchTestCase {

    @Before
    public void setUp() throws Exception {
        setDriver(new ChromeDriver());
        getDriver().get("http://localhost:8080");
    }

    @Test
    public void elementsExists() {
        Assert.assertTrue($(H1Element.class).exists());
        Assert.assertEquals(3, $(AnchorElement.class).all().size());

        $(AnchorElement.class).get(0).click();
        ElementQuery<DivElement> headerElementQuery = $(DivElement.class).attributeContains("class", "header");
        Assert.assertTrue(headerElementQuery.exists());
        Assert.assertEquals("150px", headerElementQuery.first().getCssValue("height"));
        
        ElementQuery<DivElement> footerElementQuery = $(DivElement.class).attributeContains("class", "footer");
        Assert.assertTrue(footerElementQuery.exists());
        Assert.assertEquals("100px", footerElementQuery.first().getCssValue("height"));
        
        ElementQuery<DivElement> navigationElementQuery = $(DivElement.class).attributeContains("class", "navigation");
        Assert.assertTrue(navigationElementQuery.exists());
        
        ElementQuery<DivElement> contentElementQuery = $(DivElement.class).attributeContains("class", "content");
        Assert.assertTrue(contentElementQuery.exists());
        
        $(AnchorElement.class).get(1).click();
        Assert.assertTrue($(FormLayoutElement.class).exists());
        
        $(AnchorElement.class).get(2).click();
        Assert.assertTrue($(BoardElement.class).exists());
    }
}
