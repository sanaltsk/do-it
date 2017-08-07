# Pre-work - *Do'It*

**Do'It** is an android app that allows building a todo list and basic todo items management functionality including adding new items, editing and deleting an existing item.

Submitted by: **Sanal Kumar Thekkanath**

Time spent: **X** hours spent in total

## User Stories

The following **required** functionality is completed:

* [x] User can **successfully add and remove items** from the todo list
* [x] Edit task option available in the swipe action, swipe task to left. On pressing the task, the app shows number of days to the due date.
* [x] User can **persist todo items** and retrieve them properly on app restart

The following **optional** features are implemented:

* [x] Persist the todo items [into SQLite](http://guides.codepath.com/android/Persisting-Data-to-the-Device#sqlite) instead of a text file
* [x] Improve style of the todo items in the list [using a custom adapter](http://guides.codepath.com/android/Using-an-ArrayAdapter-with-ListView)
* [x] Add support for completion due dates for todo items (and display within listview item)
* [x] Use a [DialogFragment](http://guides.codepath.com/android/Using-DialogFragment) instead of new Activity for editing items
* [x] Add support for selecting the priority of each todo item (and display in listview item)
* [x] Tweak the style improving the UI / UX, play with colors, images or backgrounds

The following **additional** features are implemented:

* [x] Swipe functionality, delete,edit,star and complete options available as swipe operations
* [x] On click on the task it shows how many days left to the due date, if the due date was specified in the task.

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='http://i.imgur.com/JUf5mgc.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />

GIF created with [LiceCap](http://www.cockos.com/licecap/).

## Project Analysis

As part of your pre-work submission, please reflect on the app and answer the following questions below:

**Question 1:** "What are your reactions to the Android app development platform so far? Compare and contrast Android's approach to layouts and user interfaces in past platforms you've used."

Android has a unique way of tying the UI and Logic together via the layouts and java files, with all the resource attributes accessible to both. Its pretty interesting as compared to the ios way of doing it where i found it a bit restrictive and had to use a lot of drag and drops to connect different things.

Android had kept the layouts, styles, colors pretty distinctive that helps in code being clean and understandable yet really easy to connect things together. It also provides different setoff predefined layouts which could easy the developer effort, yet could hack through to create custom layout for expert users.

This project was really a learning oppurtunity for me exposing lot of features that I wasnt really aware before.

**Answer:** [Enter your answer here in a paragraph or two].

**Question 2:** "Take a moment to reflect on the `ArrayAdapter` used in your pre-work. How would you describe an adapter in this context and what is its function in Android? Why do you think the adapter is important? Explain the purpose of the `convertView` in the `getView` method of the `ArrayAdapter`."

**Answer:** [Enter your answer here in a paragraph or two].
ArrayAdapter is used when we have display a set of structured data in a listview or spinner etc. We could also customize the adapter to do lot more than structuring the data. Here i have used a BaseSwipeAdapter which gets android swipe capabilites as in Apple Mail app. I felt that has an incredible user experience and hence used it in my app. How arrayadapter works is it takes one element of array and applies it to a single unit of layout and does that repeatedly till the length of the array. This helps the developer from looping through the array and setting values which could be inefficient when done the wrong way.

ConvertView is a listview cache, it works by reusing the same listview memory for all the listview operations like insert, delete or edit. And hence its memory efficient and improves the performance of the adapter.

## Notes

Describe any challenges encountered while building the app.
challenges I encoutered using the app was to trying to use BaseSwipeAdapter in the adapter, it had a bit of learning curve. Intially the UI experience while swiping was bad, took a bit of attempts to get that right.  Incorporating SQLLite with the BaseSwipeAdapter also was a bit of an issue.
  

## License

    Copyright [2017] [name of copyright Sanal Kumar]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.