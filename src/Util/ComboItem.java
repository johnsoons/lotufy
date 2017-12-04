/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author johnson
 */
public class ComboItem {
    private int key;
    private String value;

    public ComboItem(int key, String value)
    {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString()
    {
        return value;
    }

    public int getKey()
    {
        return key;
    }

    public String getValue()
    {
        return value;
    }
}
