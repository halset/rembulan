package net.sandius.rembulan.lib;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import net.sandius.rembulan.testenv.TestBase;

@FixMethodOrder(MethodSorters.JVM)
public class NotEqualsTest extends TestBase {
    
    @Test
    public void testANotEqualsBIsEquivalentToNotAEqualsB() throws Exception {
        // test that (a ~= b) is equal to not (a == b)
        // especially for comparison between two Table
        // 
        assertThat(run("""

          local T1Meta = {
              __eq = function(obj1, obj2)
                  return obj1.Value == obj2.Value
              end,
          }
          local T2Meta = {
            __eq = function(obj1, obj2)
              return obj2.Type == obj1.Type
            end
          }

          local t1 = { Type = "t1", Value = 1}
          setmetatable(t1, T1Meta)
          local t2 = { Type = "t2", Value = 2}
          setmetatable(t2, T2Meta)

          return ((t1 ~= t2) == (not (t1 == t2)) and (t1 ~= t2))
      """)[0]).isEqualTo(true);
    }
    
}
