import * as React from 'react';

import { StyleSheet, View, Button, SafeAreaView } from 'react-native';
import { setStorylyAdViewProvider } from 'storyly-monetization-react-native';
import { Storyly } from 'storyly-react-native';


export default function App() {
  var storyly: Storyly|null;
  
  return (
    <SafeAreaView style={styles.container}>
      {/* <View style={styles.box}>
        <Button 
          onPress={() => 
            StorylyMonetization.initialize(
              [MOMENTS_TOKEN], 
              [MOMENTS_USER_PAYLOAD]
            )
          }
          title="Initialize Monetization"
          color="#242450"
        />
      </View>
      <View style={styles.box}>
        <Button 
          onPress={() => StorylyMonetization.openUserStories() }
          title="Show User Stories"
          color="#00E0E4"
        />
      </View>
      */}
       <Storyly
          ref={ref => { storyly = ref }}
          style={{ width: '100%', height: 120, marginTop: 44 }}
          storylyId="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhY2NfaWQiOjU1NiwiYXBwX2lkIjoxMzg5LCJpbnNfaWQiOjE0Mjd9.cGTn_uElzFerKU-ul3EnrTn7pMZlhA3HvG4EEoygDcQ"
          onLoad={storyGroupList => {
              console.log("[Storyly] onLoad");
          }}
          onFail={errorMessage => {
              console.log("[Storyly] onFail");
          }}
          onPress={story => {
              console.log("[Storyly] onPress");
          }}
          onEvent={eventPayload => {
              console.log("[Storyly] onEvent");
          }}
          onStoryOpen={() => {
              console.log("[Storyly] onStoryOpen");
          }}
          onStoryClose={() => {
              console.log("[Storyly] onStoryClose");
          }}
          onUserInteracted={interactionEvent => {
              console.log("[Storyly] onStoryUserInteracted");
          }}/>
      <View style={styles.box}>
        <Button 
          onPress={() => setStorylyAdViewProvider(storyly, "ca-app-pub-3940256099942544/2247696110") }
          title="Add Ad Provider To Storyly"
          color="#7A4BFF"
        />
      </View> 
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 180,
    height: 60,
  },
});
