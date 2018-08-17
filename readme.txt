Test suite for the find my flock website.

Tests are arranged in a page object model. Each page on the site has a class corisponding to the selectors on that page.
Functionality tests are contained in either non-user or user folders.
constant holds all the static variables used by the test files. 

There are three separate test runs that should run independently with a new browser instance
	1. tests just the landing page is accessible
	2. tests the non user pages through navigation
	3. tests user functionality and modifying a users profile


Features still to add
	smoke test running all 3 consecutively
	selenium grid running multiple browsers and versions
	   * this cannot run simultaneously due to the user account modifications

