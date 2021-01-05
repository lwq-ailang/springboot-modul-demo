import com.wu.restful.controller.UserController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MockServletContext.class)
@WebAppConfiguration
public class ApplicationTests {

	/**
	 * 使用MockServletContext来构建一个空的WebApplicationContext，
	 * 这样我们创建的UserController就可以在@Befor函数中创建并传递到MockMvcBuilders.standaloneSetup()函数中
	 */
	private MockMvc mvc;
 
	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
	}

	/**
	 * perform：执行一个RequestBuilder请求，会自动执行SpringMvc的流程并映射到相应的控制器执行处理
	 * get(POST、PUT、DELETE)：声明发送一个get请求方法。MockHttpServletRequestBuilder get(Sring urlTemple, Object… urlVariables)：
	 * 		根据url模板和url变量值得到一个GET(POST、PUT、DELETE)请求方式的。
	 * param：添加request的参数，如上面发送请求的时候戴上了pcode=root的参数。假如使用需要发送json数据格式的时候将不能使用这种方式。
	 * andExpect：添加ResultMatcher验证规则，验证控制器执行完成后结果是否正确（对返回的数据进行的判断）
	 * andDo：添加ResultHandler结果处理器，比如调试时打印结果到控制台（对返回的数据进行的判断）
	 * andReturn：最后返回相应的MvcResult：然后进行自定义验证/进行下一步异常处理（对返回的数据进行的判断）
	 */
	@Test
	public void testUserController() throws Exception { 
        // 测试UserController 
		RequestBuilder request = null;
 
		// 1、get查一下user列表，应该为空 
		request = get("/users/"); 
		mvc.perform(request) 
				.andExpect(status().isOk()) 
				.andExpect(content().string(equalTo("[]"))); 
 
		// 2、post提交一个user 
		request = post("/users/") 
				.param("id", "1") 
				.param("name", "test") 
				.param("age", "20"); 
		mvc.perform(request) 
		        .andExpect(content().string(equalTo("success"))); 
 
		// 3、get获取user列表，应该有刚才插入的数据 
		request = get("/users/");
		mvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"test\",\"age\":20}]")));
 
		// 4、put修改id为1的user 
		request = put("/users/1") 
				.param("name", "test")
				.param("age", "30"); 
		mvc.perform(request) 
				.andExpect(content().string(equalTo("success"))); 
 
		// 5、get一个id为1的user 
		request = get("/users/1"); 
		mvc.perform(request) 
				.andExpect(content().string(equalTo("{\"id\":1,\"name\":\"test\",\"age\":30}")));
 
		// 6、del删除id为1的user 
		request = delete("/users/1"); 
		mvc.perform(request) 
				.andExpect(content().string(equalTo("success"))); 
 
		// 7、get查一下user列表，应该为空 
		request = get("/users/"); 
		mvc.perform(request) 
				.andExpect(status().isOk()) 
				.andExpect(content().string(equalTo("[]"))); 
 
	}

	@Test
	public void getThymeleafController() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/thymeleaf/hello").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("hello")));
	}
 
}