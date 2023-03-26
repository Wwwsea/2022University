package com.city.oa.test;

import com.city.oa.factory.ServiceFactory;
import com.city.oa.model.DeptModel;
import com.city.oa.service.IDeptService;

/**
 * @author:fish
 * @date: 2023/1/8-10:21
 * @content:
 */
public class TestArea {
    public static void main(String[] args) {
        IDeptService as= ServiceFactory.createAreaService();
        DeptModel am=new DeptModel();
        am.setNo(234);
        am.setName("234");
        try {
            as.add(am);
            System.out.println("OK!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
