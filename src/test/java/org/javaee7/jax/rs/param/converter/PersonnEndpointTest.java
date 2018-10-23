package org.javaee7.jax.rs.param.converter;


        import org.jboss.arquillian.container.test.api.Deployment;
        import org.jboss.arquillian.container.test.api.RunAsClient;
        import org.jboss.arquillian.junit.Arquillian;
        import org.jboss.arquillian.test.api.ArquillianResource;
        import org.jboss.shrinkwrap.api.ShrinkWrap;
        import org.jboss.shrinkwrap.api.asset.EmptyAsset;
        import org.jboss.shrinkwrap.api.spec.WebArchive;
        import org.junit.Before;
        import org.junit.Test;
        import org.junit.runner.RunWith;


        import javax.ws.rs.client.Client;
        import javax.ws.rs.client.ClientBuilder;
        import javax.ws.rs.client.WebTarget;
        import javax.ws.rs.core.MediaType;
        import javax.ws.rs.core.Response;

        import java.net.URI;
        import static org.junit.Assert.assertEquals;


@RunWith(Arquillian.class)
@RunAsClient
public class PersonnEndpointTest {

    // ======================================
    // =             Attributes             =
    // ======================================
    private Client client;
    private WebTarget personnTarget;

    // ======================================
    // =          Injection Points          =
    // ======================================

    @ArquillianResource
    private URI baseURL;

    // ======================================
    // =         Deployment methods         =
    // ======================================

    @Deployment(testable = false)
    public static WebArchive createDeployment() {

        return ShrinkWrap.create(WebArchive.class)
                .addClasses(Application.class,PersonnEndpoint.class,PersonnConverterProvider.class, Personn.class)
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    // ======================================
    // =          Lifecycle methods         =
    // ======================================

    @Before
    public void initWebTarget() {
        client = ClientBuilder.newClient();
        personnTarget = client.target(baseURL).path("api").path("personn");
    }

    // ======================================
    // =            Test methods            =
    // ======================================

    @Test
    public void shouldFindAll() throws Exception {
        Response response = personnTarget
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get();

        assertEquals(200, response.getStatus());
    }



}