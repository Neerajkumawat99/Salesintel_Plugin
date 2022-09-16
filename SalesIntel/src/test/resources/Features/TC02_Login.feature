Feature: Validate application login Page

	@Sanity @Reg
  Scenario: To validate application login page functionality
  Given Launch the url
  When Click on Chrome Extensions
  And Click on Pin From Chrome Extensions
  And Click on RevDriver by SalesIntel
  #And Switch To Child Window
  And Switch To Frame
  And Enter the UserName
  And Enter the Password
  And Click on Login CTA
  
  @Sanity @Reg
  Scenario: To validate application 1st Contact's Name functionality
  When Click on Filter Button
  And Click on Contacts Email Button
  And Enter the Firstname
  And Enter the Lastname
  And Click on Search Button
  And Click on Reveal Button
  And Click on Cancel Button
  And Wait Till Page Load To Display Select All Data 
  
  @Sanity @Reg
  Scenario: To validate application 2nd Contact's Name functionality
  When Click on Filter Button
  And Click on Contacts Email Button
  And Enter the 2nd Contacts Firstname
  And Enter the 2nd Contacts Lastname
  And Click on Search Button
  And Click on Reveal Button
  And Click on Cancel Button
  And Wait Till Page Load To Display Select All Data 
  
  @Sanity @Reg
  Scenario: To validate application 1st Contact's Email functionality
  When Click on Filter Button
  And Click on Contacts Name Email Button
  And Enter the 1st Contacts Email Address
  And Click on Search Button
  And Click on Reveal Button
  And Click on Cancel Button
  And Wait Till Page Load To Display Select All Data 
  
  @Sanity @Reg
  Scenario: To validate application 2nd Contact's Email functionality
  When Click on Filter Button
  And Click on Contacts Name Email Button
  And Enter the 2nd Contacts Email Address
  And Click on Search Button
  And Click on Reveal Button
  And Click on Cancel Button
  And Wait Till Page Load To Display Select All Data 
  
  @Sanity @Reg
  Scenario: To validate application Job Level functionality
  When Click on Filter Button
  And Click on Job Level Button
  And Select All Checkbox Option in Job Level
  And Click on Search Button
   And Click on Cancel Button
  #And UnSelect All Checkbox Option in Job Level
  #And Click on Job Level Button
  
  @Sanity @Reg
  Scenario: To validate application Job Department functionality
  Then I Wait for Page Load
  When Click on Filter Button
  And Click on Job Department Button
  And Select All Checkbox Option in Job Department
  And Click on Search Button
  And Click on Cancel Button
   #And UnSelect All Checkbox Option in Job Department
   #And Click on Job Department Button
  
  @Sanity @Reg
  Scenario: To validate application Job Title functionality
  Then I Wait for Page Load
  When Click on Filter Button
  And Click on Job Title Button
  And Click on Search Button
  
  @Sanity @Reg
  Scenario: To validate application Job Location functionality
  When Click on Filter Button
  And Click on Job Location Button
  And Click on Search Button
  
  
  
  