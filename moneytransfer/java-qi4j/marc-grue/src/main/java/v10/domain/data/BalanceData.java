/*
 * Copyright (c) 2010, Marc Grue. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package v10.domain.data;

import org.qi4j.api.common.UseDefaults;
import org.qi4j.api.injection.scope.This;
import org.qi4j.api.mixin.Mixins;
import org.qi4j.api.property.Property;
import org.qi4j.library.constraints.annotation.GreaterThan;


/**
 * Maintain a balance for an account, of any type. Methods are in past tense,
 * and are considered events. Only minimal sanity checks are performed.
 * The roles invoking these methods decide if it's ok to perform the change or not.
 */
@Mixins( BalanceData.Mixin.class )
public interface BalanceData
{
   void increasedBalance( @GreaterThan( 0 ) Integer amount );

   void decreasedBalance( @GreaterThan( 0 ) Integer amount );

   Integer getBalance();

   interface Data
   {
      @UseDefaults
      Property<Integer> balance();
   }

   class Mixin
         implements BalanceData
   {
      @This
      Data data;

      public void increasedBalance( Integer amount )
      {
         data.balance().set( data.balance().get() + amount );
      }

      public void decreasedBalance( Integer amount )
      {
         data.balance().set( data.balance().get() - amount );
      }

      public Integer getBalance()
      {
         return data.balance().get();
      }
   }
}
