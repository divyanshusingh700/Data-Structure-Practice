package InterviewQuestions.SDET;
// Different locators in Selenium

// id
// name
// className
// tagName
// linkText / partialLinkText
// cssSelector (recommended)
// xpath

// What is JavaScriptExecutor?

// Short Answer:
// JavaScriptExecutor allows us to execute JavaScript directly inside the browser through Selenium 
// when normal WebDriver actions fail or aren't supported.

// Why use it?

// Clicking hidden elements

// Scrolling into view

// Extracting browser values

// Handling dynamic UI elements

// Code Example:

JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("arguments[0].click();", element);

// More Examples

// 🔹 Scroll Page

js.executeScript("window.scrollBy(0,500)");


// 🔹 Get Page Title

String title = (String) js.executeScript("return document.title;");


// 🔹 Send Text

js.executeScript("arguments[0].value='test@example.com';", inputBox);


// Interview Line:

// JavaScriptExecutor helps when WebDriver cannot interact with certain elements due to overlays, 
// dynamic rendering, or non-standard DOM behaviors.

// ✔ Combined Short Version (Final)

// To rerun failed TestNG tests, I use IRetryAnalyzer to automatically retry failed cases, especially for intermittent UI or network issues.

// JavaScriptExecutor lets me run JavaScript directly in the browser. I use it for actions like scrolling, clicking elements WebDriver can't access normally, or fetching DOM values. Example:

((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);