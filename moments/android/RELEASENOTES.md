# Release Notes
### 0.2.0 (23.11.2022)
* IMPORTANT! deprecate createStory and openMyStories methods
* IMPORTANT! add openStoryCreator and openUserStories methods
* IMPORTANT! deprecate onOpenCreateStory and onOpenMyStory callbacks
* IMPORTANT! add onStoryCreatorOpen/onStoryCreatorClose and onUserStoriesOpen/onUserStoriesClose callbacks
* fix issue with resource conflicts for Storyly and Moments 
* add localization(en, es, de) support
* fix drag gesture position issue for text interactive component
* fix duplicate character issue on text interactive component
* fix text cut issue on text interactive component
* improve span color selection of text interactive component
* improve keyboard open/close handling
* improve ui handling for Android API 24-

### 0.1.2 (14.11.2022)
* improved audio focus with video stories

### 0.1.1 (10.11.2022)
* removed ExoPlayer2 dependency
* added Storyly-ExoPlayer2 dependency, a custom fork of ExoPlayer2

### 0.1.0 (01.11.2022)
* added video media support for create story for both gallery and camera
* added text interactive component
* added link cta interactive component

### 0.0.7 (06.10.2022)
* improved story bar scrolling performance with pagination

### 0.0.6 (03.10.2022)
* fixed a crash on gallery page for prior to Android 19 devices

### 0.0.5 (12.09.2022)
* added MomentsUserPayload to handle encrytion of user payload in mobile side
* fixed a crash on MomentsListener callback due to ProGuard

### 0.0.3 (16.08.2022)
* fixed a camera not closing bug
* fixed onUserStoriesLoaded callback bug on first call

### 0.0.1 (01.07.2022)
* introduced Moments by Storyly, Please check [Moments by Storyly Android Documentation](https://integration.storyly.io/moments-android/quick-start.html)
