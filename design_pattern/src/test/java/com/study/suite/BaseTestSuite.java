package com.study.suite;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *  类放置位置会影响执行顺序
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({BuyTest.class, LoginTest.class})
//@Suite.SuiteClasses({LoginTest.class, BuyTest.class})
public class BaseTestSuite {

}
