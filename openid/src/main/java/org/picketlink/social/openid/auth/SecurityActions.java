/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2011, Red Hat Middleware LLC, and individual contributors
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
package org.picketlink.social.openid.auth;

import java.security.AccessController;
import java.security.PrivilegedAction;

import org.jboss.security.SecurityContext;
import org.jboss.security.SecurityContextAssociation;
import org.jboss.security.SecurityContextFactory;

/**
 * Privileged Blocks
 * @author Anil Saldhana
 * @since May 19, 2011
 */
class SecurityActions
{
   static SecurityContext createSecurityContext( final String name)
   {
      return AccessController.doPrivileged(new PrivilegedAction<SecurityContext>()
      {
         public SecurityContext run()
         { 
            try
            {
               return SecurityContextFactory.createSecurityContext(name);
            }
            catch (Exception e)
            {
               throw new RuntimeException(e);
            }
         }
      });
   }
   
   static void setSecurityContext( final SecurityContext sc)
   {
      AccessController.doPrivileged(new PrivilegedAction<Void>()
      {

         public Void run()
         { 
            SecurityContextAssociation.setSecurityContext(sc);
            return null;
         }
      });
   }
   
   static SecurityContext getSecurityContext()
   {
      return AccessController.doPrivileged(new PrivilegedAction<SecurityContext>()
      {

         public SecurityContext run()
         { 
            return SecurityContextAssociation.getSecurityContext();
         }
      });
   }
   
   static ClassLoader getContextClassLoader()
   {
      return AccessController.doPrivileged(new PrivilegedAction<ClassLoader>()
      {

         public ClassLoader run()
         { 
            return Thread.currentThread().getContextClassLoader();
         }
      });
   }

}