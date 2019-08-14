package org.getspring.test.v2;

import org.getspring.beans.factory.context.ApplicationContext;
import org.getspring.beans.factory.context.support.ClassPathXmlApplicationContext;
import org.getspring.service.v2.PetStoreService;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ApplicationContextTestV2 {

    @Test
    public void testGetBeanProperty(){
        ApplicationContext context=new ClassPathXmlApplicationContext("petstore-v2.xml");
        PetStoreService petStore=(PetStoreService)context.getBean("petstore");
        assertNotNull(petStore.getAccountDao());
        assertNotNull(petStore.getItemDao());
    }
}
