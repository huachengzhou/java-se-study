package com.study.suite;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class BaseTest {

    protected static HashMap<String, Object> dataMap = new HashMap<String, Object>();
    protected final Logger logger = LoggerFactory.getLogger(getClass());
}
