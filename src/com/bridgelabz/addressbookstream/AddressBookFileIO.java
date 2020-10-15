package com.bridgelabz.addressbookstream;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;

import com.bridgelabz.addressbookstream.AddressBookMain.IOService;

public class AddressBookFileIO {

	private Map<String, Person> contactMap = new HashMap<>();
	private static final String FILE_NAME = "addressbookfile.txt";

	public AddressBookFileIO(Map<String, Person> contactMap) {
		this.contactMap = contactMap;
	}

	public void writeAddressBookFile(IOService ioService) {
		Path filePath = Paths.get(FILE_NAME);
		if (ioService.equals(IOService.FILE_IO)) {
			StringBuffer addrsBuffer = new StringBuffer();
			contactMap.values().forEach(address -> {
				String addressDataString = address.toString();
				addrsBuffer.append(addressDataString);
			});

			try {
				Path write1 = Files.write(filePath, addrsBuffer.toString().getBytes(), StandardOpenOption.WRITE);
				System.out.println(write1.toUri().getPath());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void countEntries(IOService ioService) {
		Path filePath = Paths.get(FILE_NAME);
		if (ioService.equals(IOService.FILE_IO)) {
			try {
				System.out.println("Total Entries in File: " + Files.lines(filePath).count());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
