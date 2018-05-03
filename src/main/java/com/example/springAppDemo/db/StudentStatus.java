package com.example.springAppDemo.db;

import com.fasterxml.jackson.annotation.JsonValue;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by bla on 27/04/2018.
 */

public enum StudentStatus {
    NY("ny"),
    FERDIG("ferdig");

    private final String value;
    private StudentStatus(String v) { value = v; }

    public String getValue(){ return value; }

    @JsonValue
    public String toJson(){
        //return name().toLowerCase();
        return this.getValue();
    }

}
