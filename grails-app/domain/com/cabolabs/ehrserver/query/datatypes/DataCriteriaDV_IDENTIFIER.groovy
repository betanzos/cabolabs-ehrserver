/*
 * Copyright 2011-2020 CaboLabs Health Informatics
 *
 * The EHRServer was designed and developed by Pablo Pazos Gutierrez <pablo.pazos@cabolabs.com> at CaboLabs Health Informatics (www.cabolabs.com).
 *
 * You can't remove this notice from the source code, you can't remove the "Powered by CaboLabs" from the UI, you can't remove this notice from the window that appears then the "Powered by CaboLabs" link is clicked.
 *
 * Any modifications to the provided source code can be stated below this notice.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cabolabs.ehrserver.query.datatypes

import com.cabolabs.ehrserver.query.DataCriteria

class DataCriteriaDV_IDENTIFIER extends DataCriteria {

   static String indexType = 'DvIdentifierIndex'

    String identifierValue  // needed to change the DV_IDENTIFIER.id attr name to identifier because it is used by grails for the identity.
    String typeValue
    String issuerValue
    String assignerValue


    // Comparison operands
    String identifierOperand
    String typeOperand
    String issuerOperand
    String assignerOperand

    DataCriteriaDV_IDENTIFIER()
    {
       rmTypeName = 'DV_IDENTIFIER'
       alias = 'dvidi'
    }

    //static hasMany = [valueValues: String] // FIXME: this should be one value since no spec requires a in_list or range.

    static constraints = {
       issuerValue nullable: true
       assignerValue nullable: true
       issuerOperand nullable: true
       assignerOperand nullable: true
    }
    static mapping = {
       //valueValue column: "dv_text_value"
    }

    /**
     * Metadata that defines the types of criteria supported to search
     * by conditions over DV_QUANTITY.
     * @return
     */
    static List criteriaSpec(String archetypeId, String path, boolean returnCodes = true)
    {
       return [
          [ // full criteria
             identifier: [
                contains:  'value', // ilike %value%
                eq:  'value'
             ],
             type: [
                contains:  'value', // ilike %value%
                eq:  'value'
             ],
             issuer: [
                contains:  'value', // ilike %value%
                eq:  'value'
             ],
             assigner: [
                contains:  'value', // ilike %value%
                eq:  'value'
             ]
          ],
          [ // id + type criteria
             identifier: [
                contains:  'value', // ilike %value%
                eq:  'value'
             ],
             type: [
                contains:  'value', // ilike %value%
                eq:  'value'
             ]
          ]
       ]
    }

    static List attributes()
    {
       return ['identifier', 'type', 'issuer', 'assigner']
    }

   static List functions()
   {
      return []
   }

   boolean containsFunction()
   {
      return false
   }
}
