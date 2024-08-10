## OpenInApp Assignment
Hi, I am Gaurav Saini. Below is the assignment description which is assigned to me by the OpenInApp team on 08 Aug 2024.

### Screenshot and Clip
<img src="https://github.com/user-attachments/assets/ab7336d1-5006-46d1-b2aa-cb70721899b2" width="300">

### CheckList for each point specified in the assignment
- **UI Instructions**

1. [x] Access the Figma file for the designated designs at the following location: [Openinapp UI](https://ios.openinapp.co/UITemp)
2. [x] Ensure strict adherence to the UI specifications outlined in the Figma file during the implementation process.
3. [x] Utilize the prescribed library for the integration of the graph as per the UI design. Populate the graph with data retrieved from the provided API dataset. [Click here for library](https://github.com/PhilJay/MPAndroidChart)
4. [x] Enhance user engagement by incorporating a feature to display greetings based on the local time within the application.
5. [x] Introduce a dual-tab functionality, namely "Top links" and "Recent links." Implement a list view to present data obtained from the API response in an organized manner.
6. [x] Despite the project initially being a single-pager, architect the code in a manner that anticipates future expansion, ensuring the potential for a seamless transition into a complete application encompassing multiple pages.

- **Coding Instructions**
1. [x] Programming Language: Kotlin is mandatory for the successful completion of this assignment.
2. [x] Architecture Pattern: Utilize the MVVM (Model-View-ViewModel) architecture pattern for the development of the application.
3. [x] API Integration: Employ the specified API for this assignment: https://api.inopenapp.com/api/v1/dashboardNew
4. [x] Use the given Token bearer to access and authenticate the API, the bearer token should be used in such a way that you have to use the token for multiple unique API calls.  The provided bearer token for staging API in OIA is as follows: Access Token - Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MjU5MjcsImlhdCI6MTY3NDU1MDQ1MH0.dCkW0ox8tbjJA2GgUx2UEwNlbTZ7Rr38PVFJevYcXFI
5. [x] Token Management: Ensure that the bearer token is read from local storage during runtime.
6. [x] Navigation: Employ Jetpack Navigation for seamless navigation between fragments within the application.
7. [x] Codebase: The entire codebase is currently in XML. While adhering to this, you are given the flexibility to choose between XML and Jetpack Compose based on your preference, ensuring the delivery of a high-quality and precise design.
8. [x] Networking Layer: Design the networking layer to accommodate both GET and POST API calls, ensuring robust communication with the specified API.


### Tested on -
- Samsung A23 API: 34 (Physical Device)
- Pixel 8 API: 29 (Virtual Device)
