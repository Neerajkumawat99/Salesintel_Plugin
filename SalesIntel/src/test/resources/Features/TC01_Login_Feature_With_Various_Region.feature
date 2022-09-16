Feature: Validate application login Page with various Region

	@Sanity @Reg
  Scenario: To validate application login page with Indian Region functionality
  Given Launch the url with Indian Region
  When Click on Chrome Extensions
  And Click on Pin From Chrome Extensions
  And Click on RevDriver by SalesIntel
  #And Switch To Child Window
  And Switch To Frame with Indian Region
  And Enter the UserName with Indian Region
  And Enter the Password with Indian Region
  And Click on Login CTA with Indian Region
  And Close the Browser with Indian Region
  
  @Sanity @Reg
  Scenario: To validate application login page with US Region functionality
  Given Launch the url with US Region
  When Click on Chrome Extensions
  And Click on Pin From Chrome Extensions
  And Click on RevDriver by SalesIntel
  #And Switch To Child Window
  And Switch To Frame with US Region
  And Enter the UserName with US Region
  And Enter the Password with US Region
  And Click on Login CTA with US Region
  And Close the Browser with US Region
  
  @Sanity @Reg
  Scenario: To validate application login page with UK Region functionality
  Given Launch the url with UK Region
  When Click on Chrome Extensions
  And Click on Pin From Chrome Extensions
  And Click on RevDriver by SalesIntel
  #And Switch To Child Window
  And Switch To Frame with UK Region
  And Enter the UserName with UK Region
  And Enter the Password with UK Region
  And Click on Login CTA with UK Region
  And Close the Browser with UK Region
  
  