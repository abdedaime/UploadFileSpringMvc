package com.app.controller;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileuploadController implements ServletContextAware {
	private ServletContext servletContext;
	public static final String SAVE_DIR = "uploadImage";
	private Logger log = Logger.getLogger(FileuploadController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, Model model) {
		ModelAndView view = new ModelAndView("index");
		return view;
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(
			@RequestParam(name = "file") MultipartFile multipartFile,
			Model model) {
		if (!multipartFile.isEmpty()) {
			String appPath = getServletContext().getRealPath("");
			StringBuilder filePath = new StringBuilder().append(appPath)
					.append(SAVE_DIR);

			File fileSaveDir = new File(filePath.toString());
			if (!fileSaveDir.exists()) {
				fileSaveDir.mkdir();
			}
			filePath = filePath.append(File.separator).append(
					multipartFile.getOriginalFilename());
			log.info(filePath);

			try {
				multipartFile.transferTo(new File(filePath.toString()));
			} catch (IllegalStateException | IOException e) {
				log.error("Error " + e.getMessage());
			}

		}

		return "index";
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;

	}

	public ServletContext getServletContext() {
		return servletContext;
	}

}
