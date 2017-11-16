package com.sunny;

/**
 * @author sunny
 * @className com.sunny.Test
 * @date 2017-11-16 17:44
 * @description:
 */
public class Test {
    public static void main(String[] args) {
        String str="重复数据：\r\n### Error querying database.  Cause: com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException: Duplicate entry 'task84aad95f1820412fbe7f3c6610aa2eea-task39f68232c7ff4178b1b2674' for key 'uk_project_user_user_id'\r\n### The error may exist in file [F:\\code\\java\\task\\task-server\\target\\classes\\com\\sunny\\task\\project\\mapper\\xml\\ProjectUserMapper.xml]\r\n### The error may involve defaultParameterMap\r\n### The error occurred while setting parameters\r\n### SQL: INSERT INTO project_user         (ORG_ID, PRO_ID, USER_ID, NAME, MANAGER, CREATOR, CREATION_DATE, MODIFIER)          (               select ?, ?,UNIQUE_ID,if(NICK_NAME is             null,left(EMAIL,50),NICK_NAME) name, ?, id,now(),id from app_user where             UNIQUE_ID=?          )\r\n### Cause: com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException: Duplicate entry 'task84aad95f1820412fbe7f3c6610aa2eea-task39f68232c7ff4178b1b2674' for key 'uk_project_user_user_id'\n; SQL []; Duplicate entry 'task84aad95f1820412fbe7f3c6610aa2eea-task39f68232c7ff4178b1b2674' for key 'uk_project_user_user_id'; nested exception is com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException: Duplicate entry 'task84aad95f1820412fbe7f3c6610aa2eea-task39f68232c7ff4178b1b2674' for key 'uk_project_user_user_id'";

        System.out.println(str.substring(str.indexOf("Duplicate entry"),str.indexOf("for key")));
    }
}
