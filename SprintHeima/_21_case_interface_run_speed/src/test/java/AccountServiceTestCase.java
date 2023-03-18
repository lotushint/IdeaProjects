import com.lotushint.config.SpringConfig;
import com.lotushint.domain.Account;
import com.lotushint.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class AccountServiceTestCase {
    @Autowired
    private AccountService accountService;

    @Test
    public void testFindById() {
        Account ac = accountService.findById(5);
    }

    @Test
    public void testFindAll() {
        List<Account> all = accountService.findAll();
    }
}
