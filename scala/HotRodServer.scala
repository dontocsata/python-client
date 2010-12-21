import org.infinispan.config.Configuration
import org.testng.annotations.Test
import org.infinispan.test.SingleCacheManagerTest
import org.infinispan.manager.EmbeddedCacheManager
import org.infinispan.test.fwk.TestCacheManagerFactory
import org.infinispan.server.hotrod.test.HotRodTestingUtil._

/**
 * // TODO: Document this
 * @author Galder Zamarreño
 * @since // TODO
 */
@Test(groups = Array("functional"), testName = "acme.HotRodFunctionalTest")
class HotRodServer extends SingleCacheManagerTest {

   override def createCacheManager: EmbeddedCacheManager = {
      val cacheManager = TestCacheManagerFactory.createLocalCacheManager(true)
      cacheManager.defineConfiguration("AnotherCache", new Configuration)
      val hotRodServer = createStartHotRodServer(cacheManager)
      cacheManager
   }

   protected def createStartHotRodServer(cacheManager: EmbeddedCacheManager) = startHotRodServer(cacheManager, 11222)

   @Test
   def start() {
      while(true)
         Thread.sleep(2000)
   }   

}
