package model;

import java.io.Serializable;

/**
* Created by Administrator
*  2016/12/4
*/
@Data
public class ${model} implements Serializable {
private Integer id;
<#assign h = properties>
<#assign keys = h?keys>
<#list keys as key>
private ${h[key]} ${key};
</#list>
}