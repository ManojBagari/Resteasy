package org.jboss.resteasy.client.cache;

import org.jboss.resteasy.client.core.BaseClientResponse;
import org.jboss.resteasy.spi.ResteasyProviderFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author <a href="mailto:bill@burkecentral.com">Bill Burke</a>
 * @version $Revision: 1 $
 */
public class CachedClientResponse extends BaseClientResponse
{
   protected BrowserCache.CacheEntry entry;

   public CachedClientResponse(BrowserCache.CacheEntry entry, ResteasyProviderFactory factory)
   {
      this.entry = entry;
      this.headers = entry.getHeaders();
      this.providerFactory = factory;
      this.status = 200;
   }

   public InputStream getInputStream() throws IOException
   {
      return new ByteArrayInputStream(entry.getCached());
   }

   public void releaseConnection()
   {
   }
}