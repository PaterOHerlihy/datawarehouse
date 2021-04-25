package de.pater.datawarehouse.app;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.pater.datawarehouse.data.Tweet;
import de.pater.datawarehouse.data.TweetService;
import de.pater.datawarehouse.data.User;
import de.pater.datawarehouse.data.UserService;

public class Extractor {

	private UserService uServ = new UserService();
	private TweetService tServ = new TweetService();

	public void extractToDB(File file) throws IOException {

		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		mapper.findAndRegisterModules();

		int i = 0;

		try (Scanner sc = new Scanner(file, "UTF-8")) {

			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				i++;
				System.out.println(i);
				User tempUser = mapper.readValue(line, User.class);
				Tweet t = mapper.readValue(line, Tweet.class);
				t.setAuthor(tempUser);

				if (uServ.findById(tempUser.getId()) == null && tServ.findById(t.getId()) == null) {

					tempUser.tweets.add(t);
					uServ.persist(tempUser);
					tServ.persist(t);

				} else if (tServ.findById(t.getId()) == null) {
					tempUser.tweets.add(t);
					uServ.update(tempUser);
					tServ.persist(t);
				}

			}
		}

		finally {
		}

	}

}
