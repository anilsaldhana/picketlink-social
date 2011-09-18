/*
* JBoss, Home of Professional Open Source.
* Copyright 2008, Red Hat Middleware LLC, and individual contributors
* as indicated by the @author tags. See the copyright.txt file in the
* distribution for a full listing of individual contributors. 
*
* This is free software; you can redistribute it and/or modify it
* under the terms of the GNU Lesser General Public License as
* published by the Free Software Foundation; either version 2.1 of
* the License, or (at your option) any later version.
*
* This software is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
* Lesser General Public License for more details.
*
* You should have received a copy of the GNU Lesser General Public
* License along with this software; if not, write to the Free
* Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
* 02110-1301 USA, or see the FSF site: http://www.fsf.org.
*/
package org.picketlink.social.openid;

import java.io.Serializable;
import java.net.URL;
import java.security.Principal;
import java.util.List;
import java.util.Map;

/**
 * A {@link Principal} representing an OpenID Authenticated principal
* @author Marcel Kolsteren
* @author Anil Saldhana
* @since Jan 30, 2010
*/
public class OpenIdPrincipal implements Principal, Serializable
{ 
   private static final long serialVersionUID = 4404673070085740561L;

   private String identifier;

   private URL openIdProvider;

   private Map<String, List<String>> attributes;

   public OpenIdPrincipal(String identifier, URL openIdProvider, Map<String, List<String>> attributes)
   {
      super();
      this.identifier = identifier;
      this.openIdProvider = openIdProvider;
      this.attributes = attributes;
   }

   public String getName()
   {
      return identifier;
   }

   public String getIdentifier()
   {
      return identifier;
   }

   public URL getOpenIdProvider()
   {
      return openIdProvider;
   }

   public Map<String, List<String>> getAttributes()
   {
      return attributes;
   }

   @Override
   public String toString()
   {
      return "OpenIdPrincipal [identifier=" + identifier + ", openIdProvider=" + openIdProvider + ", attributes="
            + attributes + "]";
   }
}