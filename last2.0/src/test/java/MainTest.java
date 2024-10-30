import Menus.Menu;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class MainTest {

    @Test
    public void testMain() {
        Menu mockMenu = mock(Menu.class);

        Main.setMenu(mockMenu);

        Main.main(new String[]{});

        verify(mockMenu).menu();
    }
}
