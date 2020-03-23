package com.mainacad.service.search;

public class SaverOne {
    static Integer result;

    public static synchronized Integer saveResult(Integer searched){
        result = searched;
        return  result;
    }
}
