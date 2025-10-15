from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from webdriver_manager.chrome import ChromeDriverManager
import time

driver = webdriver.Chrome(ChromeDriverManager().install())
driver.get("http://automationpractice.com")

wait = WebDriverWait(driver, 10)

search_box = wait.until(EC.presence_of_element_located((By.ID, "search_query_top")))
search_box.send_keys("dress")
search_box.send_keys(Keys.RETURN)

# Click on first product result (product container -> product name link)
first_product = wait.until(EC.element_to_be_clickable((By.XPATH, "(//ul[contains(@class,'product_list')]/li//a[@class='product-name'])[1]")))
first_product.click()

# Wait for 'Add to cart' button to be visible and click it
add_to_cart_btn = wait.until(EC.element_to_be_clickable((By.XPATH, "//p[@id='add_to_cart']/button")))
add_to_cart_btn.click()

# Wait for the modal and click 'Proceed to checkout'
proceed_btn = wait.until(EC.element_to_be_clickable((By.XPATH, "//a[@title='Proceed to checkout']")))
proceed_btn.click()

# Summary page - verify cart title
summary_title = wait.until(EC.presence_of_element_located((By.XPATH, "//h1[text()='Shopping-cart summary']")))

assert "Shopping-cart summary" in summary_title.text

# Optional: Proceed to checkout again (as guest)
proceed_summary = wait.until(EC.element_to_be_clickable((By.XPATH, "//p[@class='cart_navigation clearfix']/a[@title='Proceed to checkout']")))
proceed_summary.click()

# Email input on Authentication page
email_input = wait.until(EC.presence_of_element_located((By.ID, "email_create")))
email_input.send_keys(f"testuser_{int(time.time())}@example.com")

create_account_btn = driver.find_element(By.ID, "SubmitCreate")
create_account_btn.click()

# Wait for account creation form to appear
account_form = wait.until(EC.presence_of_element_located((By.ID, "account-creation_form")))

# Fill out required fields
driver.find_element(By.ID, "customer_firstname").send_keys("Test")
driver.find_element(By.ID, "customer_lastname").send_keys("User")
driver.find_element(By.ID, "passwd").send_keys("Password123")

driver.find_element(By.ID, "address1").send_keys("123 Testing Lane")
driver.find_element(By.ID, "city").send_keys("Testville")

# Select state (dropdown)
from selenium.webdriver.support.ui import Select
state_dropdown = Select(driver.find_element(By.ID, "id_state"))
state_dropdown.select_by_visible_text("California")

driver.find_element(By.ID, "postcode").send_keys("90001")
driver.find_element(By.ID, "phone_mobile").send_keys("1234567890")
driver.find_element(By.ID, "alias").clear()
driver.find_element(By.ID, "alias").send_keys("My Address")

# Register
driver.find_element(By.ID, "submitAccount").click()

# Proceed to checkout on address page
driver.find_element(By.NAME, "processAddress").click()

# Agree to terms
driver.find_element(By.ID, "cgv").click()

# Proceed to checkout on shipping
driver.find_element(By.NAME, "processCarrier").click()

# Choose payment method (bank wire)
driver.find_element(By.XPATH, "//a[@title='Pay by bank wire']").click()

# Confirm order
driver.find_element(By.XPATH, "//button[contains(@class,'button-medium') and @type='submit']").click()

# Verify order confirmation
confirmation_msg = wait.until(EC.presence_of_element_located((By.XPATH, "//p[@class='cheque-indent']/strong")))

assert "Your order on My Store is complete" in confirmation_msg.text

driver.quit()
