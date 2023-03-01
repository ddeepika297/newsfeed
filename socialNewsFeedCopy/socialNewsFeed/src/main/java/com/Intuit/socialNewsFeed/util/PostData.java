package com.Intuit.socialNewsFeed.util;

import java.util.HashMap;
import java.util.Map;

import com.Intuit.socialNewsFeed.model.CategoryEnum;

public class PostData {

	public final static String sports = "[\r\n" + "      {\r\n"
			+ "        \"postId\" : \"34563c12\", \"postCreatorID\" : \"643005dc\", \"content\" : \"sports1\", \"url\" :null, \"creationDateTime\" : \"1677671897\", \"category\": \"Sports\"\r\n"
			+ "      },\r\n" + "      {\r\n"
			+ "       \"postId\" : \"735e32d9\", \"postCreatorID\" : \"1a33e081\", \"content\" : \"sports2\", \"url\" :null, \"creationDateTime\" :\" 1677672293\", \"category\": \"Sports\"\r\n"
			+ "      },\r\n" + "      {\r\n"
			+ "       \"postId\" : \"135e32d9\", \"postCreatorID\" : \"0a38e081\", \"content\" : \"sports3\", \"url\" :null, \"creationDateTime\" :\" 1677699985\", \"category\": \"Sports\"\r\n"
			+ "      },\r\n" + "      {\r\n"
			+ "       \"postId\" : \"jewe32d9\", \"postCreatorID\" : \"k338e081\", \"content\" : \"sports4\", \"url\" :null, \"creationDateTime\" :\" 1677699989\", \"category\": \"Sports\"\r\n"
			+ "      }\r\n" + "    ]";
	public final static String music = "[\r\n" + "      {\r\n"
			+ "        \"postId\" : \"34563c12\", \"postCreatorID\" : \"643005dc\", \"content\" : \"Music1\", \"url\" :null, \"creationDateTime\" : \"1677674171\", \"category\": \"Music\"\r\n"
			+ "      },\r\n" + "      {\r\n"
			+ "       \"postId\" : \"735e3209\", \"postCreatorID\" : \"1a33e081\", \"content\" : \"Music2\", \"url\" :null, \"creationDateTime\" :\" 1577674171\", \"category\": \"Music\"\r\n"
			+ "      },\r\n" + "      \r\n" + "      {\r\n"
			+ "       \"postId\" : \"7323e3209\", \"postCreatorID\" : \"0233e081\", \"content\" : \"Music3\", \"url\" :null, \"creationDateTime\" :\" 1677674171\", \"category\": \"Music\"\r\n"
			+ "      },\r\n" + "      \r\n" + "      {\r\n"
			+ "       \"postId\" : \"735e3254\", \"postCreatorID\" : \"1a33e281\", \"content\" : \"Music4\", \"url\" :null, \"creationDateTime\" :\" 1677674171\", \"category\": \"Music\"\r\n"
			+ "      },\r\n" + "      {\r\n"
			+ "       \"postId\" : \"7326e3209\", \"postCreatorID\" : \"0233e001\", \"content\" : \"Music5\", \"url\" :null, \"creationDateTime\" :\" 1677671171\", \"category\": \"Music\"\r\n"
			+ "      },\r\n" + "      \r\n" + "      {\r\n"
			+ "       \"postId\" : \"732303209\", \"postCreatorID\" : \"1233e081\", \"content\" : \"Music6\", \"url\" :null, \"creationDateTime\" :\" 1677674155\", \"category\": \"Music\"\r\n"
			+ "      }\r\n" + "    ]";
	public final static String meme = "[\r\n" + "      {\r\n"
			+ "        \"postId\" : \"34563c12\", \"postCreatorID\" : \"643005dc\", \"content\" : \"meme1\", \"url\" :null, \"creationDateTime\" : \"1677673795\", \"category\": \"Music\"\r\n"
			+ "      },\r\n" + "      {\r\n"
			+ "       \"postId\" : \"735e3209\", \"postCreatorID\" : \"1a33e081\", \"content\" : \"meme2\", \"url\" :null, \"creationDateTime\" :\" 1677673795\", \"category\": \"Music\"\r\n"
			+ "      },\r\n" + "  {\r\n"
			+ "       \"postId\" : \"7323e3209\", \"postCreatorID\" : \"0233e081\", \"content\" : \"meme3\", \"url\" :null, \"creationDateTime\" :\" 1677412699\", \"category\": \"Music\"\r\n"
			+ "      },\r\n" + "      {\r\n"
			+ "       \"postId\" : \"735e3254\", \"postCreatorID\" : \"1a33e281\", \"content\" : \"meme4\", \"url\" :null, \"creationDateTime\" :\" 1677412699\", \"category\": \"Music\"\r\n"
			+ "      }\r\n" + "    ]";
	public final static String bollywood = "[\r\n" + "      {\r\n"
			+ "        \"postId\" : \"34563c412\", \"postCreatorID\" : \"643005dc\", \"content\" : \"bollywood1\", \"url\" :null, \"creationDateTime\" : \"1677673795\", \"category\": \"Music\"\r\n"
			+ "      },\r\n" + "      {\r\n"
			+ "       \"postId\" : \"1735e32209\", \"postCreatorID\" : \"51a33e081\", \"content\" : \"bollywood2\", \"url\" :null, \"creationDateTime\" :\" 1677412699\", \"category\": \"Music\"\r\n"
			+ "      },\r\n" + "      {\r\n"
			+ "       \"postId\" : \"47323e31209\", \"postCreatorID\" : \"30233e081\", \"content\" : \"bollywood3\", \"url\" :null, \"creationDateTime\" :\" 1677412699\", \"category\": \"Music\"\r\n"
			+ "      },\r\n" + "      {\r\n"
			+ "       \"postId\" : \"735e32554\", \"postCreatorID\" : \"11a33e281\", \"content\" : \"bollywood4\", \"url\" :null, \"creationDateTime\" :\" 1677673795\", \"category\": \"Music\"\r\n"
			+ "      }\r\n" + "    ]";
	public final static String Bangalore = "[\r\n" + "      {\r\n"
			+ "        \"postId\" : \"34563c412\", \"postCreatorID\" : \"643005dc\", \"content\" : \"bangalore1\", \"url\" :null, \"creationDateTime\" : \"1677707893\", \"category\": \"Music\"\r\n"
			+ "      },\r\n" + "      {\r\n"
			+ "       \"postId\" : \"1735e32209\", \"postCreatorID\" : \"51a33e081\", \"content\" : \"bangalore2\", \"url\" :null, \"creationDateTime\" :\" 1677706893\", \"category\": \"Music\"\r\n"
			+ "      },\r\n" + "      {\r\n"
			+ "       \"postId\" : \"47323e31209\", \"postCreatorID\" : \"30233e081\", \"content\" : \"bangalore3\", \"url\" :null, \"creationDateTime\" :\" 1677709893\", \"category\": \"Music\"\r\n"
			+ "      },\r\n" + "      {\r\n"
			+ "       \"postId\" : \"735e32554\", \"postCreatorID\" : \"11a33e281\", \"content\" : \"bangalore4\", \"url\" :null, \"creationDateTime\" :\" 1677707894\", \"category\": \"Music\"\r\n"
			+ "      }\r\n" + "    ]";
	
	static Map<CategoryEnum, String> map = new HashMap<>();
	static {
		map.put(CategoryEnum.Sports, sports);
		map.put(CategoryEnum.Music, music);
		map.put(CategoryEnum.Meme, meme);
		map.put(CategoryEnum.Bollywood, bollywood);
		map.put(CategoryEnum.Bangalore, Bangalore);
	}

	public static Map<CategoryEnum, String> getMap() {
		return map;
	}
}
