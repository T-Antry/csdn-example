package org.antry;
import org.antry.service.impl.UserServiceImpl;
import javax.xml.ws.Endpoint;

public class PublishTest
{
    public static void main( String[] args )
    {
        Endpoint.publish("http://127.0.0.1:11111/user",new UserServiceImpl());
    }
}
