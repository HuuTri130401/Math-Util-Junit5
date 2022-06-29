/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.trith.mathutil.core;

import static com.trith.mathutil.core.MathUtil.*;
//import static danh rieng cho nhung ham static 
//goi ham ma bo qua ten class
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 *
 * @author Admin
 */
public class MathUtilTest {
    
    //chơi DDT , tách data ra khỏi câu lệnh kiểm thử tham số hóa data này
    //vào trong câu lệnh kiểm thử 
    
    //chuẩn bị bộ data 
    public static Object[][] initData(){
        return new Integer[][] {
                                    {1, 1},
                                    {2, 2},
                                    {5, 120},
                                    {6, 720}
                                    };
            
    }
    
    @ParameterizedTest
    @MethodSource(value = "initData") //tên hàm cung cấp data, ngầm định thứ tự của mảng
    //map vapf tham số hàm
    public void testGetFactorialGivenRightArgReturnWell(int input, long expected){
        assertEquals(expected, getFactorial(input));
    }
    
//    @Test
//    public void testGetFactorialGivenRightArgReturnWell(){
//        assertEquals(24, getFactorial(4));
//    }
    
    //Bắt ngoại lệ khi đưa data cà chớn 1!
//    @Test(expected = tên ngoại lệ) JUnit 4 hoi, ...ko sài 
    @Test
    public void testFactorialGivenWrongThrowException(){
        //Xài biểu thức lambda
        //hàm nhận tham số thứ 2 là 1 object có code implement functional interface tên là executable - có 1 hàm duy nhất ko code 
        //tên là execute()
//        Executable exObject = new Executable() {
//            @Override
//            public void execute() throws Throwable {
//                getFactorial(-5);
//            }
//        }; //new thì phải ";"
                
//        Executable exObject = () -> {getFactorial(-5);};
//        assertThrows(IllegalArgumentException.class, exObject );
        Executable exObject = () -> getFactorial(-5);
        assertThrows(IllegalArgumentException.class, () -> getFactorial(-5));
        
    }
    
}
