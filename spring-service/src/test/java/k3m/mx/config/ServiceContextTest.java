package k3m.mx.config;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import k3m.mx.service.BookService;

@Ignore("ignored so tests step does not try to run tests in here and fail")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ServiceContext.class)
public class ServiceContextTest {
	
	@Autowired
	protected BookService bookService;

}

